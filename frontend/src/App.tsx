import './App.css'
import {SetStateAction, useState} from "react";
import * as React from "react";

const App = () => {
    const [inputValue, setInputValue] = useState('');
    const [moves, setMoves] = useState('0:0:N');

    const handleChange = async (event: { target: { value: SetStateAction<string>; }; }) => {
        setInputValue(event.target.value);
        const response = await fetch("https://d49ut6g7e1.execute-api.eu-west-1.amazonaws.com/serverless_lambda_stage/rover", {
            body: JSON.stringify({"input": ""}),
            method: "POST"
        });
        const finalRoverPosition = await response.json();
        setMoves(finalRoverPosition);
    }

    return <>
        <input type="text" value={inputValue} onChange={handleChange}></input>
        <label>Insert value</label>
        <p>Value: {moves}</p>
    </>
}

export default App
