import { render } from '@testing-library/react';
import React, { Component } from 'react';
import Movie from './Movie';
import propTypes from "prop-types";


function Food({name,picture,rating}){
  
  return (<div>
<h2>I like {name}</h2>
<h4>{rating} / 5.0</h4>
<img src={picture}

/>  
</div>   
); 
 
}

Food.propTypes = {
  name:propTypes.string.isRequired,
  picture:propTypes.string.isRequired,
  rating:propTypes.number.isRequired
};

const foodIlike = [
  
{
name:"kimchi", 
id:3,
image : 
"http://image.genie.co.kr/Y/IMAGE/IMG_ARTIST/067/872/918/67872918_1616652768439_20_600x600.JPG",
rating : 5

},
{
name:"kimcha",
id:1,
image : 
"http://image.genie.co.kr/Y/IMAGE/IMG_ARTIST/067/872/918/67872918_1616652768439_20_600x600.JPG",
rating:3
}



];

function renderFood(dish){
return <Food key={dish.id} name={dish.name} picture={dish.image} rating={dish.rating}/>
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