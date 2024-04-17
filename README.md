# Apptware-Tests

Welcome to the Apptware-Tests repository! This repository contains all failing test cases for the initial coding challenge at Apptware. Candidates who wish to join Apptware will need to fix these failing tests to demonstrate their code-reading and problem-solving abilities.

## Getting Started

To participate in the coding challenge, follow these steps:

1. **Fork the Repository**: Click the "Fork" button at the top-right corner of this repository to create your own copy.

2. **Clone the Repository**: After forking, clone the forked repository to your local machine using Git.

    ```bash
    git clone https://github.com/your-username/apptware-tests.git
    ```

## Running Tests Locally

Once you have cloned the repository, navigate to its directory and run the tests using Gradle:

```bash
cd apptware-tests
./gradlew :test --info
```

This command will execute all the tests in the repository. Since all test cases are expected to fail initially, don't be alarmed by the results!

## Analyzing Failure Reasons

To effectively fix the failing tests, it's crucial to understand why they are failing. Analyze the error messages, stack traces, and the logic of the code to identify the root causes of failure.

## Fixing the Tests

Implement fixes for the failing tests based on your analysis. Modify the code as necessary to ensure that the tests pass.

## Testing Locally

After applying your fixes, test the code locally by running the tests again:

```bash
./gradlew :test --info
```

Ensure that all the tests now pass before proceeding.

## Submitting Your Solution

Once you have fixed the failing tests and verified that they pass locally, it's time to submit your solution. Create a pull request (PR) from your forked repository to the main repository. In the PR description, briefly explain the changes you've made and provide any additional information you deem necessary.

## Waiting for Review

After submitting your solution, our team will review it and provide feedback. If your solution meets the requirements and passes all the test cases, you'll be one step closer to joining Apptware!

Happy coding, and best of luck with the challenge! If you have any questions or need assistance, feel free to reach out to us.