//import React from 'react';
//
//var KhoaPham = React.createClass({
//	render: function(){
//		return(
//			<h1 className="mauvang">Khoa Pham</h1>
//		);
//	}
//});

class Greeting extends React.Component {
    render() {
        return (<p>Hello world</p>);
    }
}

ReactDOM.render(
	<div>
  		HoangKien
  		<Greeting />
  	</div>,
  	document.getElementById('root')
);  