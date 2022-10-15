let payment_info = document.querySelector("input[type=submit]");
payment_info.addEventListener("click", showMsg);

function showMsg(){

    var name = document.getElementById("username").value;

    var gender = '';
    if(document.getElementById("male").checked){
        gender = "male";
    }
    else if(document.getElementById("female").checked){
        gender = "female";
    }

    var address = document.getElementById("address").value;
    var email = document.getElementById("email").value;
    var pincode = document.getElementById("pincode").value;
    var cardType = document.getElementById("card_type").value;
    var cardNumber = document.getElementById("card_number").value;
    var expDate = document.getElementById("exp_date").value;
    var cvv = document.getElementById("cvv").value;

    var letters = /^[A-Za-z]+$/;
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var numeric = /^[0-9]+$/;

        if(name=='')
		{
			alert('Please enter your name');
		}
		else if(!letters.test(name))
		{
			alert('Name field required only alphabet characters');
		}
        else if(gender==''){
            alert('Please select your gender');
        }
        else if(address==''){
            alert('Please enter your address');
        }
        else if(email=='')
		{
			alert('Please enter your user email id');
		}
		else if (!filter.test(email))
		{
			alert('Invalid email');
		}
        else if(pincode=='')
		{
			alert('Please enter your pincode');
		}
        else if(!numeric.test(pincode))
		{
			alert('Please enter your pincode in numbers only');
		}
        else if(pincode.length>6)
        {
            alert('Pincode should contain only 6 characters');
        }
        else if(cardType==''){
            alert('Please choose your card type')
        }
        else if(cardNumber==''){
            alert('Please enter your card number');
        }
        else if(!numeric.test(cardNumber)){
            alert('Please enter a valid card number');
        }
        else if(expDate==''){
            alert('Please enter the expiration date of your card');
        }
        else if(cvv=='')
		{
			alert('Please enter the cvv of your card');
		}
        else if(!numeric.test(cvv))
		{
			alert('The cvv of your card should contain numbers only');
		}
        else if(cvv.length>3)
        {
            alert('The cvv of your card should contain only 3 characters');
        }
        else
		{				                            
            alert('Payment Information has been updated successfully.');
		}

}