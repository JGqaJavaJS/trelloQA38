versions:

Java 8
Gradle 7.4
------------------

Gradlew start/run commands/pipelines:

-----------------
./gradlew clean test - run all tests
./gradlew clean newtest - run all tests from the task newtest (suite -> else)
./gradlew clean -Dsuite=login newtest - run tests for login from "if"
commit: 6b92aa0
----------------
./gradlew clean -Pbrowser=firefox newtest - run with firefox
./gradlew clean -Pbrowser=chrome newtest  - run with chrome
./gradlew clean newtest - run with chrome
commit 11be5ad
----------------
to add all current settings:
./gradlew clean -Pbrowser=firefox -Dsuite=login newtest
-----------------
groups:
./gradlew clean -Pbrowser=firefox -Dsuite=login -Dgroups=smoke newtest
-------------------
properties file:
 ./gradlew clean -Pbrowser=firefox -Ptarget=preprod -Dsuite=login -Dgroups=smoke newtest
---------------------------



trello.com -> prod
preprod.trello.com -> pre prod
qa-25.trello.com -> env for qa (personal)

_____________________

let str = `some var in the text ${varName}`

add comment for Pull Request
