# sirnornur-azop

**Problem:** provide lowest possible rate for borrowers from the given `csv` file.

### Getting started

Clone it locally: 
```
git clone https://github.com/sirnornur/sirnornur-apoz.git sirnornur-apoz
```

Build the `jar` file using the Maven:
```
cd sirnornur-apoz
mvn clean package
```

This creates a file `target/quote.jar`.
Run that `jar` file using `JRE v1.8` and provide the arguments:
```
java -jar samples/input.csv 1000
```

### Further improvements
This solution can be improved in the following ways:
- compile/package the `jar executable` to Microsoft Windows executable file `quote.exe`.
- introduce a more accurate `RepaymentCalculator` implementation with the correct formula. The currently used formula provides results that slightly differ from the examples in the problem statement.
- improve test coverage: add more tests to check the repayment formula and to check various csv files.
