# play-lambda-sample [![Build Status](https://travis-ci.org/Enalmada/play-lambda-sample.svg?branch=master)](https://travis-ci.org/Enalmada/play-lambda-sample) [![Join the chat at https://gitter.im/Enalmada/play-lambda-sample](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/Enalmada/play-lambda-sample?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

[![Join the chat at https://gitter.im/Enalmada/play-lambda-sample](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/Enalmada/play-lambda-sample?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

This project contains the code necessary to run a sample of PlayFramework on AWS Lambda.
To avoid reinventing the wheel, I tried to learn from someone who has done it.
I did find one article but it wasn't in my language and there was no github code attached.
So due credit goes to this post as the starting point: http://tech.recruit-mp.co.jp/server-side/post-5473/

## Quickstart
- Clone the project
- Run "sbt assembly" on the terminal to create a single jar file out of the project
- Upload the new jar to an s3 bucket. (jar file is too big for aws lambda client upload)
- Create an AWS Lambda function 
 -- Name: play-lambda-sample
 -- Runtime: java8
 -- Choose upload zip from s3 and pass in the url to your jar in s3
 -- Handler: example.PlayTask::exec
 -- Role: lambda_s3_exec_role (you will need to choose s3 execution role and this is what aws will create)
- Test the function
 -- Choose sample event: S3 Put
 -- Hit Invoke.  You should see "Hello, AWS Lambda in Play" and then some summary and logging info.
- Configure event to function
 -- Common triggers are lambda scheduler or connecting function to API gateway so rest api call triggers it.
 
## Notes
- Because Lambda has a second of latency for cold start, and there is a second latency because play starts fresh with every invocation, there is a few seconds latency which means this
  concept is only conducive to batch jobs or post-processing the user is not waiting for.  Beanstalk is still the preferred way to run traditional web services using play.
- If you want to keep looking into Lambda for serverless applications, consider the Jaws framework.  

## License

Copyright (c) 2015 Adam Lane

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License. You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
  