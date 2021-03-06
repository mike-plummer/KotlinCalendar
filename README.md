# Kotlin Calendar
Implementation of a personal calendar as a demonstration of Kotlin grammar and features

There's a [blog post](https://objectpartners.com/2016/02/23/an-introduction-to-kotlin/) that walks through my impressions of Kotlin coming from a Java background.

## Kotlin Overview
Kotlin is (yet another) JVM language but with a unique set of features that will appeal to many developers. Kotlin is similar in many ways to Groovy in that Kotlin code can use Java and be used by Java which makes it easy to integrate and gives you the power of the expansive set of Java frameworks and libraries out there.

As I see it, Kotlin has a number of killer features:

* **Null safety**: All variables are guaranteed non-null unless explicitly marked as nullable. This forces you to think more about how to structure your data. Allows null-safe traversals via `?.` notation
* **Boilerplate Reduction**: Getters and setters are auto-generated, data classes auto-generate equals/hashCode/toString and copy constructors
* **Flexibility**: Allows operator overloading, adding _extension_ functions to classes without subclassing, functions and properties can be easily delegated
* **Java Goodness**: Kotlin has all the latest Java features including lambdas and stream-esque operations
* **Nitpick Fixes**: Auto-casting after checking class types, ability to inline functions like C, and destructuring support

## Setup
The preferred method for running this project is Gradle. Just run `gradle -q` from project root which will by default compile and launch the main class, the -q flag suppresses Gradle output which is helpful since this is a console-based program.

There are several other options available to you if you prefer to not use Gradle:
 * IntelliJ
 * Eclipse
 * Kotlin Command Line Tools

Information and downloads for these are available @ [kotlinlang.org](https://kotlinlang.org).

## Instructions
To run, execute the main function in KotlinCalendar.kt. The console will prompt for commands to allow to you create, delete, and list calendar data as well as exit the program.

## Tests
A variety of unit tests have been written using [Spek](https://jetbrains.github.io/spek/), a unit testing framework that is 100% Kotlin-based. For those who have worked with Spock or Mocha it will be very familiar - tests are broken down into a series of nested "given-on-it" clauses to help semantically structure your tests and encourage targeted, readable tests.
