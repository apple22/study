import React from "react";
import "../routes/Home.css";

class Detail extends React.Component{
    componentDidMount(){
        console.log(this.props);
        const {location ,history} = this.props;
        console.log(location.props);
        if(location.state === undefined){
            history.push("/");
            
        }
    }
    render(){
        const {location } = this.props;
       if(location.state){
        return <span>{location.state.title}</span>;
       }else{
           return null;
       }

       
    }
}
export default Detail;