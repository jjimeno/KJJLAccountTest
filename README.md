# KJJLAccountTest

# Why this project

After doing the [iOS version of this project](https://github.com/jjimeno/JJLBAccountTest) I decided to make the android app
This project contains an android app with an accompanying wear app.

# The problem

Given some data with a format similar to [response.json](https://github.com/jjimeno/KJJLAccountTest/blob/master/mobile/src/main/assets/response.json), you need to create:
- an app that shows a list of accounts
- 2 different lists need to be displayed, the complete account list and other with only the visible accounts.
- You want to show the data in a watch app or widget

# Architecture

Clean Principles with MVP. Async with kotlin coroutines.

# Project structure
- domain module : Contains the interfaces & implementation of the domain. In module has no android dependencies
- nativelibs module: Contains android implementation of some domain libraries needed for both android wear app & android app
- mobile module: android app. It contains the android app code
- wear module: wear app. It contains the android wear code. 

# License

MIT License

Copyright 2017 Jose Jimeno Linares

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
