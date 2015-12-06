# play-lambda-sample [![Build Status](https://travis-ci.org/Enalmada/play-lambda-sample.svg?branch=master)](https://travis-ci.org/Enalmada/play-lambda-sample) [![Join the chat at https://gitter.im/Enalmada/play-lambda-sample](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/Enalmada/play-lambda-sample?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

This project contains the code necessary to run a sample of PlayFramework on AWS Lambda.
To avoid reinventing the wheel, I tried to learn from someone who has done it.
I did find one article but it wasn't in my language and there was no github code attached.
So due credit goes to this post as the starting point: http://tech.recruit-mp.co.jp/server-side/post-5473/

## Quickstart
- Clone the project
- Run "sbt assembly" on the terminal to create a single jar file out of the project
- Upload the new jar to an s3 bucket. (jar file is too big for aws lambda client upload)
- Create an AWS Lambda function 
--   

## License

Copyright (c) 2015 Adam Lane

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License. You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
  