import React, { Component } from 'react';

class EventPractice extends Component {

    state = {
        username : '',
        message: '' , 
        phone : ''
    }

/* 임의 메서드 만들기 
이벤트에 실행할 자바스크립트 코드를 전달하는것이 아니라 
함수형태로 전달하는 방식 , 기능상에는 차이가 없지만 , 가독성 , 속도면에서 훨씬 높음 
*/
   constructor(props){
      super(props);
      this.handleChange = this.handleChange.bind(this);
      this.handleClick = this.handleClick.bind(this);
   }

   handleChange(e){
       this.setState({
          [e.target.name] : e.target.value
       });
   }

   handleClick(){
       alert(this.state.username + ':' + this.state.message + ':' + this.state.phone);
       this.setState({
           username : '',
           message : '',
           phone : ''
       });
   }

handleKeyPress = (e) =>{
   if(e.key === "Enter"){
       this.handleClick();

   }
}


   render(){
       return(
           <div>
<h1>test</h1>
<input type="text" name="username" placeholder="이름" value={this.state.username}
onChange={this.handleChange} onKeyPress={this.handleKeyPress}
/>
<input type="text" name="message" placeholder="아무거나" value={this.state.message} 
onChange={this.handleChange} onKeyPress={this.handleKeyPress}/>

<input type="text" name="phone" placeholder="번호" value={this.state.phone} 
onChange={this.handleChange} onKeyPress={this.handleKeyPress}/>

<button onClick={this.handleClick}>확인</button>

           </div>
       );
   }

}


export default EventPractice;