# custom-components

Custom Apache Camel Components.

The project is a collection of various Custom Camel components
that can be used within Camel routes (From Camel 3).

# prerequisite

- JDK11+
- Maven
- Assimbly Base (https://github.com/assimbly/base)

# build

This project can be build with Maven:

```mvn clean install```

It's also possible to build only one module at the time.
For this the same Maven command can be executed, but then
from the directory that contains pom.xml of that module.

For example:

```
cd ./aggregate
mvn clean install
```

# build with a script

In the bin folder there are also a few scripts to build the components.


```build```

or 

```buildandtest```

You can also build a single module

```build modulename```

or

```buildandtest modulename```

