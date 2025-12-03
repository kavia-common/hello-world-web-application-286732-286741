#!/bin/bash
cd /home/kavia/workspace/code-generation/hello-world-web-application-286732-286741/springboot_backend
./gradlew checkstyleMain
LINT_EXIT_CODE=$?
if [ $LINT_EXIT_CODE -ne 0 ]; then
   exit 1
fi

