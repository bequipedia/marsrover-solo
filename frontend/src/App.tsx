import './App.css'
import {useState} from "react";

function App() {
    const [inputValue, setInputValue] = useState('');
    const [moves, setMoves] = useState('0:0:N');

    const handleChange = async (event) => {
        setInputValue(event.target.value);
        const response =
            await fetch("https://d49ut6g7e1.execute-api.eu-west-1.amazonaws.com/serverless_lambda_stage/rover",
                {body: JSON.stringify({"input": ""}), method: "POST", mode: "no-cors"});
        const finalRoverPosition = await response.text();
        setMoves(finalRoverPosition)
    }

    return (
        <>
            <label>Insert value
                <input type={"text"} value={inputValue} onChange={handleChange}/>
            </label>
            <p>Value: {moves}</p>
        </>
    )
}

export default App
