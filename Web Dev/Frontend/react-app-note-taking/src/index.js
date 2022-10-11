import React, { useState } from "react";
import ReactDOM from "react-dom";
import App from "./components/App";
import Notes from "./components/Notes";

const Form = () => {
  const [inputList, setInputList] = useState([]);

  const onAddBtnClick = (event) => {
    setInputList(inputList.concat(<Notes />));
  };

  return (
    <div>
      <button className="button" onClick={onAddBtnClick}>
        Add Note
      </button>
      {inputList}
    </div>
  );
};

ReactDOM.render(<Form />, document.getElementById("form"));
ReactDOM.render(<App />, document.getElementById("root"));
