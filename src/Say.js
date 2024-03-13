import React, { Component, useState } from 'react';

//useState : 함수의 인자에는 초기값을 넣어줌 , useState에서는 객체를 넣을 필요는 없음
// 객체도 되고 , 문자도되고 , 배열도되고 , 숫자도 되고 
const Say = () =>{
const [message, setmessage] = useState('');
const onClickEnter = () => setmessage("안녕하세요");
const onClickLeave = () => setmessage("안녕히가세요");
const [color,setColor] = useState('black');

return(
<div>
    <button onClick={onClickEnter}>입장</button>
    <button onClick={onClickLeave}>퇴장</button>
    <h1 style={{color}}>{message}</h1>
    <button style={{color:'red'}} onClick={()=>setColor('red')}>빨간색</button>
    <button style={{color:'blue'}} onClick={()=>setColor('blue')}>파란색</button>
    <h1>{message}</h1>
</div>

);
};

export default Say;