import React, { Component } from 'react';
//constructor : 생성자 메서드 
//super : constructor 를 작성할때 반드시 사용 해야 함 
class Counter extends Component {
  state = {
     number:0,
     fixedNumber:0
  };

render(){
const {number , fixedNumber} = this.state; // state 조회할때 쓰는 this.state
return(
<div>
<h1>{number}</h1>
<h2>바뀌지 않는 값 : {fixedNumber}</h2>
<button /*onclick을 통해 버튼이 클릭되었을때 호출되는 함수 지정 */onClick = {()=>{
this.setState({number:number + 1 }, () => {

    console.log("방금 setstate 호출");
    console.log(this.state);
}
    );
//this.setState를 통해 state에 새로운 값을 넣을수 있음
}}>
> + 1    
</button> 
</div>
);
};
}//counter

export default Counter;