Gradlew start commands:

./gradlew clean test - run all tests
./gradlew clean newtest - run all tests from the task newtest (suite -> else)
./gradlew clean -Dsuite=login newtest - run tests for login from "if"
commit: 6b92aa0
----------------
./gradlew clean -Dbrowser=firefox newtest - run with firefox
./gradlew clean -Dbrowser=chrome newtest  - run with chrome
./gradlew clean newtest - run with chrome
----------------