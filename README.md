# StockPortfolio
Android project that consumes data from a websocket. Built with MVVM, Kotlin Flow, Clean architecture. 

## Prerequisite
To build this project, you require:
- Android Studio 
- Gradle 7.4
- Kotlin 1.6.10
- Android Gradle Plugin 7.1.2

## Design

In approaching this project, I focused on the architecture of the data layer. I leveraged retrofit
and Kotlin coroutines to fetch data from the APIs and used an enum to switch between the different APIs
simulating the Success, Empty and Error states.

On the UI I used Jetpack Compose + ViewModels to build a unidirectional flow of data from the UI to
the data source and back.

## Architecture

The application follows clean architecture in order to take advantage of its inherent benefits such as
scalability, maintainability and testability. It enforces separation of concerns and dependency
inversion, where higher and lower level layers all depend on abstractions.

#### Data
I broke the data layer into 2 modules:

- Remote - a module that encapsulates the network calls and exposes a class `StocksDataSource` that
  other modules can consume.
- stock-data-lib - depends on the remote module to retrieve the Stock data and defines the
  business logic for switching between the Success, Error and Empty APIs.

For dependency injection and asynchronous programming, the project uses Dagger Hilt and Coroutines
with Flow. Dagger Hilt is a fine abstraction over the vanilla dagger boilerplate, and is easy to
setup. Coroutines and Flow brings kotlin's conciseness to asynchronous programming, along with a
fine suite of operators that make it a robust solution.

#### Domain

The domain layer contains the app business logic. It defines contracts for data operations and
domain models to be used in the app. All other layers have their own representation of these domain
models, and Mapper classes (or adapters) are used to transform the domain models to each layer's
domain model representation. Usecases which represent a single unit of business logic are also
defined in the domain layer, and are consumed by the presentation layer.

Writing mappers and models can take a lot of effort and result in boilerplate, but they make the
codebase much more maintainable and robust by separating concerns.

## Testing

The app contains unit tests in all the modules. You can run all tests by executing the gradle
task `runTests`

## Copied Code

The project contains some copied (pronounced `borrowed`) code from [Tivi](https://github.com/chrisbanes/tivi)
an open source repository that details how to build a modern mobile application using Jetpack compose.
All the copied code can be found in the `compose-commons` module which is used exclusively on the UI layer for
state management and styling.

## Time

After the initial project setup, I spent about 4 hours working on the actual task of making the network calls, the UI
and tests.