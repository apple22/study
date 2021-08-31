import React from "react";
import { HashRouter ,Route } from "react-router-dom";
import About  from "./routes/about";
import Home from "./routes/home";
import Navigation from "./component/Navigation";
import Detail from "./component/detail";


function App(){
return(
<>
<HashRouter>
    <Navigation/>
<Route path="/" exact={true} component={Home}/>
<Route path="/about" exact={true} component={About}/>
<Route path="/movie/:id" component={Detail}/>
</HashRouter>
<footer></footer>
</>
);
}

export default App;