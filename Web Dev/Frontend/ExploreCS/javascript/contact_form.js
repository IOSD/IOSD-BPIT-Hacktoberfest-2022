let contact = document.querySelector("input[type=submit]")
contact.addEventListener("click", showMsg);

function showMsg(){
    var name= document.getElementById("username").value;
    var email= document.getElementById("email").value;
    var message= document.getElementById("message").value;
    var subject= document.getElementById("subject").value;

	var letters = /^[A-Za-z]+$/;
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        if(name=='')
		{
			alert('Please enter your name');
		}
		else if(!letters.test(name))
		{
			alert('Name field required only alphabet characters');
		}
		else if(email=='')
		{
			alert('Please enter your user email id');
		}
		else if (!filter.test(email))
		{
			alert('Invalid email');
		}
        if(message=='')
		{
			alert('Please enter your message');
		}
		else if(document.getElementById("message").value.length > 1000)
		{
			alert ('Message max length is 1000');
		}
        if(subject=='')
		{
			alert('Please enter your subject');
		}
		else if(document.getElementById("subject").value.length > 100)
		{
			alert ('Subject max length is 100');
		}
        else
		{				                            
            alert('You have logged in successfully');
		}
}