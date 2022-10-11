import React from "react";
import Header from "./Header";
import Footer from "./Footer";
import Notes from "./Notes";

function App() {
  return (
    <div>
      <Header />
      <div className="body">
        <Notes />
      </div>
      <Footer />
    </div>
  );
}

export default App;
