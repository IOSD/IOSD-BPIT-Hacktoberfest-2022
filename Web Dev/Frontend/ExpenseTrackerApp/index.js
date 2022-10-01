var balance = 0;
const months = ["January","February","March","April","May","June","July","August","September","October","November","December"];
var time = new Date().getTime()
var date = new Date().getDate()
var monthName = new Date().getMonth();
var month = months[monthName];
var year = new Date().getFullYear();

function handleIncome()
{
var income = parseInt(document.getElementById("incomeInput").value);
balance += income;
document.querySelector("h2").innerHTML = "Your Balance: " + balance;
const incomePara = document.createElement("p");
document.getElementById("record").prepend(incomePara);
var text = document.getElementById("textInput").value;
incomePara.innerText = `Credit Added: ${income} on ${date} ${month} ${year}
 ${text}`;
// / ${month} / ${year} at ${time} ${text}`;



}
function handleExpense()
{
var expense = parseInt(document.getElementById("incomeInput").value);
balance -= expense;
document.querySelector("h2").innerHTML = "Your Balance: " + balance;
const expensePara = document.createElement("p");
document.getElementById("record").prepend(expensePara);
expensePara.innerText = `Credit Deducted: ${expense} ${date}`;
}
/*function appendIncome()
{

        const incomePara = document.getElementById("record").createElement(p);
        const input = document.getElementById("record").createTextNode(expense);
        incomePara.appendChild(input);
    
}
 
function appendExpense()
{
    const expensePara = document.getElementById("record").createElement(p);
    const input = document.getElementById("record").createTextNode(income);
    expensePara.appendChild(input) 

}*/


