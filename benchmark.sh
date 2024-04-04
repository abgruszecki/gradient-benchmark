#!/usr/bin/env bash

DIR=./target/benchmark-results
MAIN=./target/main

# BIN=./benchmark-code/target/scala-3.4.0/benchmark-out
BIN=./optimized/target/scala-3.4.0/optimized-out

run-code() {
    $MAIN "$@" >"$DIR/out" 2>"$DIR/err"
}

run-instrumented-code() {
    strace $MAIN "$@" >"$DIR/iout" 2>"$DIR/ierr"
}

main() {
    NUM_ITER=1000

    mkdir -p "$DIR"

    if [[ -n $1 ]]; then
        NUM_ITER=$1
    fi

    cp "$BIN" $MAIN || exit

    echo "# of iterations: $NUM_ITER"
    echo "Running normal code..."
    time bash ./benchmark.sh run-code "$NUM_ITER"
    echo "Running instrumented code..."
    time bash ./benchmark.sh run-instrumented-code "$NUM_ITER"
    echo "Done."

}

CMD=$1
shift

if [[ -z $CMD ]]; then
    main "$@"
elif [[ $CMD = main ]]; then
    main "$@"
elif [[ $CMD = run-code ]]; then
    run-code "$@"
elif [[ $CMD = run-instrumented-code ]]; then
    run-instrumented-code "$@"
else
    echo "Unrecognized command: $CMD"
    echo "Try: main"
fi
