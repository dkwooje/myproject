가상화 후 서버 배포와 redis 그리고 컨테이너 docker를 하기 전 홈페이지의 백엔드와 프론트엔드를 만들었습니다.
프론트엔드 위주 코딩인 JSON을 활용한 방식입니다.


먼저 백엔드를 소개 시켜드립니다. 
백엔드의 프레임워크는 Spring boot, 도구는 intelliJ, 언어는 java17그리고 lombok과 JPA방식을 사용하였습니다.


![스크린샷(34)](https://github.com/user-attachments/assets/8729e143-b897-492e-959b-9cf9966ccde1)


intelliJ로 만든 백엔드의 controller 부분입니다.
mapping어노테이션을 활용하여 URL를 통하여 데이터를 받도록 설정해 줍니다. 
또한 JSON형식의 데이터를 받도록 RequestBody어노테이션 설정을 해줍니다.


![스크린샷(38)](https://github.com/user-attachments/assets/47164cc5-7eb9-4f0e-8372-356a2397d42b)
![스크린샷(39)](https://github.com/user-attachments/assets/5a6f1510-3f60-45fb-af28-61ddba48601e)
![스크린샷(41)](https://github.com/user-attachments/assets/b39db656-a79e-42e0-9b02-592084fd5e6f)
![스크린샷(42)](https://github.com/user-attachments/assets/7fc2aec1-1cb5-4948-96cb-5ca6198c7d91)
![스크린샷(43)](https://github.com/user-attachments/assets/928ba010-4a69-454c-b30a-581c88a3a394)
POSTMAN 툴은 URL 경로를 통해 JSON데이터를 보낼 수 있습니다.
원하는 기능(CRUD)과 원하는 경로(url)을 설정하고 원하는 데이터(JSON)을 보낼 수 있습니다. 


![스크린샷(40)](https://github.com/user-attachments/assets/b07cdd21-d598-422b-8991-acd12dac89f9)
잘 처리가 되면 위와 같이 데이터베이스(MYSQL,AWS RDS)에 저장이 됩니다.

![스크린샷(44)](https://github.com/user-attachments/assets/b77b661f-50c9-4415-a759-30921dc8aef0)
데이터베이스에 데이터가 잘 처리가 되었다면 정상적인 백엔드의 기능을 프론트 엔드로 보내줍니다.



다음으로는 프론트 엔드를 소개 시켜드립니다. 
프론트엔드의 프레임워크는 React, 도구는 visual studio code, 언어는 javascript그리고 node.js를 사용하였습니다.


![스크린샷(49)](https://github.com/user-attachments/assets/2e48dc38-bdb8-4237-a077-7b7458162862)
router를 통해 경로를 설정합니다. 기본 경로는 http://localhost:3000/ 으로 설정하였습니다. 백엔드에서 보내는는 URL주소와 같습니다.



![스크린샷(47)](https://github.com/user-attachments/assets/ac092439-b999-4a9c-86fb-d7ac19473b0b)
![스크린샷(48)](https://github.com/user-attachments/assets/8d38fc5f-3a59-4dcd-b137-a4c79c6b9ba8)
또한 async를 사용해 비동기 방식으로 백엔드의 mapping을 통해 데이터를 전달합니다.

![스크린샷(50)](https://github.com/user-attachments/assets/72a41075-3fcf-42a1-b523-51b22b59f572)
node.js를 통해 서버를 실행시켜 봅니다. 
전달한 각 기능과 실제 URL 주소에 따라 그리고 데이터베이스로부터 되돌려 받는 데이터가 잘 작동됩니다.

간단하게 화면(UI)를 통해 데이터가 전달되고 처리하고 데이터베이스에 저장 되는 순서를 역순으로 나열해 보았습니다.
프론트엔드 위주의 json형식의 홈페이지 만드는 법을 배웠습니다.









