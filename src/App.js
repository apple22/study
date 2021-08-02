import { render } from '@testing-library/react';
import React, { Component } from 'react';
import Movie from './Movie';


function Food({name,picture}){
  
  return (<div>
<h2>I like {name}</h2>
<img src={picture}

/>  
</div>  
); 
 
}

const foodIlike = [
  
{
name:"kimchi", 
id:3,
image : 
"http://image.genie.co.kr/Y/IMAGE/IMG_ARTIST/067/872/918/67872918_1616652768439_20_600x600.JPG"

},
{
name:"kimcha",
id:1,
image : 
"http://image.genie.co.kr/Y/IMAGE/IMG_ARTIST/067/872/918/67872918_1616652768439_20_600x600.JPG"

}



];

function renderFood(dish){
return <Food key={dish.id} name={dish.name} picture={dish.image}/>
}

function App(){ 
  return(
    <div>
      {console.log(foodIlike.map(renderFood))}
      {foodIlike.map(renderFood)}
      </div>
  );
}  
export default App;  