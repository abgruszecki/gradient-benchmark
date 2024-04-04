#!/usr/bin/env python3
import os
import re
import sys

syscallRx = re.compile('^[a-zA-Z][^ ]*\\(')

in_enclosure = False
gc_pauses = 0
gc_switches = 0
syscalls = 0
mmaps = 0
response_times = []

results_dir = sys.argv[1]
assert(os.path.exists(results_dir))

with open(os.path.join(results_dir, 'err')) as baseline_trace:
    for ln in baseline_trace:
        if ln.startswith('Response time: '):
            time = int( ln[len('Response time: '):].strip() )
            response_times.append(time)

baseline_responses = len(response_times)
avg_response_time_ns = sum(response_times) / baseline_responses

print(f'Analyzed the baseline trace.')
print(f'Responses: {baseline_responses}')
print(f'Average response time (in ms): {avg_response_time_ns/1000}')

response_times = []

with open(os.path.join(results_dir, 'ierr')) as instrumented_trace:
    for ln in instrumented_trace:
        if ln.startswith('Enclosure+'):
            in_enclosure = True
        elif ln.startswith('Enclosure-'):
            in_enclosure = False
        elif ln.startswith('Response time: '):
            time = int( ln[len('Response time: '):].strip() )
            response_times.append(time)
        elif ln.startswith('mmap('):
            mmaps += 1
        elif ln.startswith('Collect'):
            gc_pauses += 1

        if in_enclosure:
            if syscallRx.match(ln):
                syscalls += 1
            elif ln.startswith('Collect'):
                gc_switches += 1

avg_gc_switches = gc_switches / len(response_times)
avg_syscalls = syscalls / len(response_times)

print(f'Analyzed the instrumented trace.')
print(f'Responses: {len(response_times)}')
if len(response_times) != baseline_responses:
    print('\nALERT!')
    print(f'MISMATCH BETWEEN THE NUMBER OF RESPONSES! Proceeding anyway.')
    print('\nALERT!\n')
print(f'Average INSTRUMENTED response time (in ms): {(sum(response_times)/len(response_times))/1000}')
print(f'GC switch #: {gc_switches}')
print(f'Per request: {avg_gc_switches}')
print(f'(GC pause #: {gc_pauses})')
print(f'Syscall   #: {syscalls}')
print(f'Per request: {avg_syscalls}')
print(f'mmap      #: {mmaps}')

baseline_call = 45
baseline_transfer = 0
baseline_syscall = 387
mpk_call_cost = 86-baseline_call
mpk_transfer_cost = 1002-baseline_transfer
mpk_syscall_cost = 523-baseline_syscall
vtx_call_cost = 86-baseline_call
vtx_transfer_cost = 158-baseline_transfer
vtx_syscall_cost = 4126-baseline_syscall

def print_cost(name, cost):
    print(f'{name} (in ns): {cost} (+{ 100*(cost / (avg_response_time_ns)) }%)')

print('\nMPK cost estimates (per request):')
mpk_enclosure_cost = 5 * mpk_call_cost
mpk_avg_gc_switch_cost = avg_gc_switches * mpk_call_cost
mpk_avg_syscalls_cost = avg_syscalls * mpk_syscall_cost
mpk_avg_transfer_cost = (mmaps/len(response_times)) * mpk_transfer_cost
print_cost('Enclosure cost', mpk_enclosure_cost)
print_cost('GC switch cost', mpk_avg_gc_switch_cost)
print_cost('Syscalls cost', mpk_avg_syscalls_cost)
print_cost('Transfer cost', mpk_avg_transfer_cost)
print_cost('Total cost', mpk_enclosure_cost+mpk_avg_gc_switch_cost+mpk_avg_syscalls_cost+mpk_avg_transfer_cost)

print('\nVTX cost estimates (per request):')
vtx_enclosure_cost = 5 * vtx_call_cost
vtx_avg_gc_switch_cost = avg_gc_switches * vtx_call_cost
vtx_avg_syscalls_cost = avg_syscalls * vtx_syscall_cost
vtx_avg_transfer_cost = (mmaps/len(response_times)) * vtx_transfer_cost
print_cost('Enclosure cost', vtx_enclosure_cost)
print_cost('GC switch cost', vtx_avg_gc_switch_cost)
print_cost('Syscalls cost', vtx_avg_syscalls_cost)
print_cost('Transfer cost', vtx_avg_transfer_cost)
print_cost('Total cost', vtx_enclosure_cost+vtx_avg_gc_switch_cost+vtx_avg_syscalls_cost+vtx_avg_transfer_cost)
