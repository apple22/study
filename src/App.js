import React from 'react';
import Say from './Say';
//Props(properties) : 컴포넌트 속성을 설정할때 사용하는 요소 , 
//prop값으로 해당 컴포넌트를 불러와서 사용하는 부모 컴포넌트에서 설정 가능 
//defaultProps: 기본값 설정
//children : 태그사이의 내용을 보여줌 
//propsType를 통한 props 검증
//isRequired  : 필수 propsType

/* propType 종류 
array : 배열 
array of : 특정 proptype로 이루어진 배열 
bool : true 혹은 false
func : 함수
number : 숫자
object : 객체 
string : 문자열 
oneofType : 주어진 배열안의 종류 중 하나 
*/

/*State : 컴포넌트 내부에서 바뀔수 있는 값 
props는 컴포넌트가 사용되는 과정에서 부모 컴포넌트가 설정하는 값이라면 
state는 부모객체를 거치지않고도 변경 가능 ! 
*/

const App = () => {
  return <Say/>;
};

export default App;