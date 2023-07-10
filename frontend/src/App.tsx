import './App.css'
import {ChangeEvent, useState} from "react";



function App() {
    const [inputValue, setInputValue] = useState('');
    const [moves, setMoves] = useState('0:0:N');

    const handleChange = async (event: ChangeEvent<HTMLInputElement>) => {
        setInputValue(event.target.value);
        const response = await fetch("https://d49ut6g7e1.execute-api.eu-west-1.amazonaws.com/serverless_lambda_stage/rover", {
            body: JSON.stringify({"input": ""}),
            method: "POST"
        });
        const finalRoverPosition = await response.json();
        setMoves(finalRoverPosition);
    }

    return (<div>
        <input type="text" value={inputValue} onChange={handleChange}/>
        <label>Insert value</label>
        <p>Value: {moves}</p>
    </div>)
}

export default App
