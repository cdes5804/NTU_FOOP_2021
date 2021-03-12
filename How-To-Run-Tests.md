# How To Run Tests

Follow the steps below under your project directory:
1. `cd src`
2. `javac TestSuite.java -d ../out/`
3. `cd ..`
4. `java -cp out/ TestSuite <testcase's name>`
> Replace `<testcase's name>` with the testcase's name you can find under the testcases/ directory. 
> For example `java -cp out/ TestSuite always-play-first-card`