# Number Demo
A small kata how to convert numbers, nothing special
## Usage
In order to run the application you need java 17 and gradle.

Install the gradle wrapper (it was already included - 
but maybe if smoething is wrong try to retry it :D ):

```
gradle wrapper
```

build it with gradle

```
./gradlew build
```

and then you can run the applicaiton from the build directory

```
 java -jar build/libs/number-demo-0.0.1-SNAPSHOT.jar /Users/marcus/number-demo/src/main/java/com/example/numberdemo/NumberDemoApplication.java
```

Or simply import it into your IDE of your choice (e.g. Intellij IDEA) 
and let that do it's magic to build and run the NumberDemoApplication

Then you can open http://localhost:8080/convert/binary-to-roman/1101 
or http://localhost:8080/convert/decimal-to-roman/42 to see the results. 

Unfortunately my available time did not allow me to include a running swagger documentation.

# Rough architecture

Honestly the architecture is a bit rough around the edges. 
Nevertheless ther are some main elements:

- `com.example.numberdemo.ConversionController` is handling all requests and just doing that. The general URL patter is `/convert/{in}-to-{out}/{value}`. The output is kepüt super simple (to avoid the word simplistic)
- `com.example.numberdemo.Converter` is doing the real number conversion. It knows a number of inputters to read the number to an integer and a number of outputters to write it back to an external format.
- As inputters there is `com.example.numberdemo.inputters.BinaryInputter` and `com.example.numberdemo.inputters.DecimalInputter`- reading their respective number formats
- As outputters there is currently only `com.example.numberdemo.outputters.RomanOutputter`

The whole application is wired in com.example.numberdemo.NumberDemoApplication. 
The mapping of the inputters and outputters to url parameters 
is done in `src/main/resources/application.yml`.

_Nota bene_: Context Scanning was intentionally omitted 
to make all beans explicitly know in the config 
and reduce the amount of surprise adding new classes.

## Adding inputters/outputter
To add new inout or output formats implement 
a respective way of `com.example.numberdemo.inputters.Inputter` or `com.example.numberdemo.outputters.Outputter`, add it to the classpath and add the mapping to `src/main/resources/application.yml` (or configure overwriting keys)

## Rough parts

As mentioned above a nice swagger ui with and nice opeanpi documentation 
would have been super useful.

Honestly running the java application from the command line if not very ideal. 
Wrapping everythig up in a nice docker container would have been nice - but was not realized

The whole application configuration is a bit bit static and monolitic. 
The configuration is currently mixing up a good amount of aspects - 
but more separation may come with more stuff (and time). 
Better supporting spring boot autoconfiguration with various configuration parts would have been nice. 