import React, { Component, useState } from 'react';

const IterationSample = () => {
   const [names,setNames] = useState([
        {id: 1 , text : '피자'},
        {id: 2 , text : '햄버거'},
        {id: 3 , text : '치킨'},
        {id: 4 , text : '파스타'}

   ]);

   const [inputText , setInputText] = useState('');
   const [nextId , setNextId] = useState(5);/*새로운 항목을 추가할때 사용할 id*/

    const onChange = e => setInputText(e.target.value);
    const onClick = () => {
        const nextNames = names.concat({
                id:nextId,
                text:inputText
        });
        /*concat : 인자로 주어진 배열이나 값들을 기존배열 합침 
        문자열합치기
        */

        setNextId(nextId + 1);/*nexid 값에 1을 더해줌 */
        setNames(nextNames);/*names값을 업데이트*/
        setInputText('');//inputText를 비워둠
    }

    const onRemove = id =>{
        const nextNames = names.filter(name => name.id !== id);
        /*특정배열에서 특정원소만 제외시키고싶을때 사용 */
        setNames(nextNames);
    }

/*filter : 특정조건을 만족하는 원소들만 쉽게 배열해서 추가하거나 삭제할수있음  */
   const namesList = names.map(name=> <li key={name.id} onDoubleClick={()=>onRemove(name.id)}>{name.text}</li>);
   return(
       <>
    <input value={inputText} onChange={onChange} />
    <button onClick={onClick} >추가</button>
    <ul>{namesList}</ul>
  </>
   );
}

export default IterationSample;