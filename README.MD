# KotlinFullStackAppTemplate
Is my template for large fullstack projects on Kotlin
## Run
If you want to run this example you should follow instructions below
- gradle module:server:run
- gradle app:desktop:run
## Structure
Every module contains sub modules 
### Common
Is interface module 
I recommend to create in this module 
- interfaces
- dtos
- exception
- small utils
### Core
Is core logic of module
Is better to use with di framework
I recommend to create in this module
- interface implementations
- model classes
- repositories
- DI container
### Client
Is client model which contains only client implementations of common module
### Server
Is server implementation of common module or core
Is better to use with di framework
I recommend to create in this module if you implemented core
- repository implementations
- framework specific classes like route config etc.
- DI container
### UI
Is a collection of components related to common module
I recommend to create in this module 
- classes and inject interfaces from common
- create components for required dtos in class