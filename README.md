# The dependencies of the benchmark
Building the benchmark code and its dependencies requires Java and SBT.
Both can be installed by following the instructions here: 
https://www.scala-lang.org/download/.

## Building scala-native
Run the following commands.

```
$ cd scala-native
$ sbt
```

You are now in SBT console. 
Run the commands below, one-by-one or connected with a semicolon if you want.

```
> publish-local-dev 3.4.0
> javalib3/publishLocal
> auxlib3/publishLocal
> windowslib3/publishLocal
> posixlib3/publishLocal
> clib3/publishLocal
> nativelib3/publishLocal
> testInterface3/publishLocal
> junitRuntime3/publishLocal
> testInterfaceSbtDefs3/publishLocal
> project nscplugin3
> set scalaVersion := "3.4.0"
> publishLocal
```

## Building scala-xml
Run the following commands:

```
$ cd scala-xml
$ sbt publishLocal
```

## Building the benchmark code
Run the following command:
```
$ sbt optimized/nativeLink
```

Optimizing the code may take a few minutes.
It is easier to iterate on the unoptimized version:

```
$ sbt nativeLink
```

# Running the benchmark
Assuming the code is built, run:

```
# Second parameter is the number of iterations.
$ ./benchmark.sh main 100000
$ ./analyze.py target/benchmark-results
```