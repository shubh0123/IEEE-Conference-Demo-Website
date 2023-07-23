    //first request to server to create order 
    const createOrder = () => {
        console.log("create order");
      //Generate amount dynamically on the server with the helf of foem filled by the client.
      //Getting the value of dropdown
        let email=document.getElementById("email").value;
        let participant_category = document.getElementById("participant_category");
        let participant_category_text = participant_category.options[participant_category.selectedIndex].text;
        let participant_membership = document.getElementById("participant_membership");
        let participant_membership_text = participant_membership.options[participant_membership.selectedIndex].text;
if(participant_category_text == "-- Select Participants Category --" || participant_category_text == null|| participant_membership_text == "-- Select Participants Membership --" || participant_membership_text == null|| email == null || email == ""){
    
        alert("Please select the email, participant category and membership type");
            return false;
        }
          //email validation 
        var atposition=email.indexOf("@");
        var dotposition=email.lastIndexOf(".");
        if (atposition<1 || dotposition<atposition+2 || dotposition+2>=email.length){
            alert("Please enter a valid e-mail address");
            return false;
        }
        
    if(participant_membership_text == "IEEE Member"){
        if(participant_category_text == "Participants from Industry"){
            var amount = 9000;
            initializingRazorpay(amount,"INR",email);
        }
        else if(participant_category_text == "Participants from Academics"){
            var amount = 700;
            initializingRazorpay(amount,"INR",email);
        }
        else if(participant_category_text == "Students participants"){
            var amount = 5500;
              initializingRazorpay(amount,"INR",    email);
        }
        else if(participant_category_text == "Foreign Participants "){//foreign participants

             //convert above amount usd to inr using ajax online dynamically
				var amount =250;
				
                initializingRazorpay(amount,"USD",email);
 
        }
    else if(participant_category_text == "Listener/ Additional registration (Academics / Industry)"){
            var amount = 1500;
            initializingRazorpay(amount,"INR",email);
        }
        else if(participant_category_text == "Listener/ Additional registration (Students)"){
            var amount = 700;
            initializingRazorpay(amount,"INR",email);
        }
    }
    else {
        if(participant_category_text == "Participants from Industry"){
            var amount = 11000;
            initializingRazorpay(amount,"INR",email);
        }
    
        else if(participant_category_text == "Participants from Academics"){
            var amount = 8500;
            initializingRazorpay(amount,"INR",email);
        }
        else if(participant_category_text == "Students participants"){
            var amount = 6500;
            initializingRazorpay(amount,"INR",email);
        }
        else if(participant_category_text == "Foreign Participants "){//foreign participants
             var amount 
                 initializingRazorpay(amount,"USD",email);
    
              // Amount in USD
             
            
               
        }
        else if(participant_category_text == "Listener/ Additional registration (Academics / Industry)"){
            var amount = 2500;
            initializingRazorpay(amount,"INR",email);
        }
        else if(participant_category_text == "Listener/ Additional registration (Students)"){
            var amount = 1000;
            initializingRazorpay(amount,"INR",email);
        }
    }
    
    
        //we will use ajax to send request to server to create order-jquery
        
        function initializingRazorpay(amount,currency,email){
         
        $.ajax({
            url: '/createOrder',//url of server
            data: JSON.stringify({amount: amount, info: 'order_request', currency:currency}),//data we are sending to server
            contentType: 'application/json',//type of data we are sending
            type: 'POST',//request type
            dataType: 'json',//return type
            success: function(data){//invoke when success
                data.currency=currency;
                console.log(data);
                            if(data.status == "created"){
                    //open payment form
                    let options = {
                        "key": "rzp_test_Dn0WYeYaBLZF58", // Enter the Key ID generated from the Dashboard
                        "amount": data.amount, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
                        "currency": data.currency,//we are using INR
                        "name": "Registration Fees",
                        "description": "Test Transaction",
                        "image": "https://firebasestorage.googleapis.com/v0/b/ieee-conference-607a3.appspot.com/o/Websitelogo.jpg?alt=media&token=c58e6043-1ce3-439d-8933-2c6ded6aec9b",
                        "order_id": data.id, //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
                        "handler": function (response){
                            console.log(response);
                            //alert(response.razorpay_payment_id);
                            //alert(response.razorpay_order_id);
                            //alert(response.razorpay_signature)
                             updatePaymentOnServer(response.razorpay_payment_id, response.razorpay_order_id, "paid");
                            console.log("Payment Successfull");
                                             
                            disableButton();

                            //submit the form
                        
                        },
                        "prefill": {
                        "name":"",
                           "email":email,
                       "contact":""
                        },
                        "notes": {
                            "address": "IEEE Conference"
                        },
                        "theme": {
                            "color": "#3399cc"
                        },
    
    
    
                };
                let rzp = new Razorpay(options);
                rzp.on('payment.failed', function (response){
                    console.log(response.error.code);
                    console.log(response.error.description);
                    console.log(response.error.source);
                    console.log(response.error.step);
                    console.log(response.error.reason);
                    console.log(response.error.metadata.order_id);
                    console.log(response.error.metadata.payment_id);
                   swal("Payment Failed", "Please try again", "error");
                }
                );    
                rzp.open();
            }
                
            },
            error: function(error){//invoke when error
                console.log(error);
                 alert("Please try again");//show alert
            }
        })
        
    }
}
    function disableButton(){
	
	      var email = document.getElementById("email");
        email.setAttribute("readonly", "readonly");
        var payment_button = document.getElementById("payment_button");
        payment_button.setAttribute("disabled", "disabled");
                var participant_membership = document.getElementById("participant_membership");
        participant_membership.addEventListener("mousedown", function(event) {
  event.preventDefault();
}, false);
        var participant_category = document.getElementById("participant_category");
       participant_category .addEventListener("mousedown", function(event) {
  event.preventDefault();
}, false);
        payment_button.setAttribute("style", "background-color: #4CAF50;");
        payment_button.setAttribute("style", "cursor: not-allowed;");
        payment_button.setAttribute("style", "color: white;");
        payment_button.setAttribute("style", "padding: 15px 32px;");
        payment_button.setAttribute("style", "text-align: center;");
        payment_button.setAttribute("style", "text-decoration: none;");
         payment_button.setAttribute("style", "display: inline-block;");
        payment_button.setAttribute("style", "font-size: 16px;");
        payment_button.innerHTML = 'Payment Successfull <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check2-circle" viewBox="0 0 16 16"><path d="M2.5 8a5.5 5.5 0 0 1 8.25-4.764.5.5 0 0 0 .5-.866A6.5 6.5 0 1 0 14.5 8a.5.5 0 0 0-1 0 5.5 5.5 0 1 1-11 0z"/><path d="M15.354 3.354a.5.5 0 0 0-.708-.708L8 9.293 5.354 6.646a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l7-7z"/></svg>';
        
        enableButton();
      
    }
    function enableButton(){
            var submit_button = document.getElementById("submit_button");
        submit_button.removeAttribute("disabled");
    }
    
    
    function updatePaymentOnServer(payment_id,order_id,status){
        //we will use ajax to send request to server to create order-jquery
    
        $.ajax({
            url: '/update_payment',//url of server
            data: JSON.stringify({
                payment_id: payment_id, 
                order_id: order_id, 
                status: status
            }),//data we are sending to server
            contentType: 'application/json',//type of data we are sending
            type: 'POST',//request type
            dataType: 'json',//return type
            success: function(data){//invoke when success
                        console.log("payment Successfull:"+data);
                    alert("Payment Successfull");
            },
            error: function(error){//invoke when error
                console.log(error);
                alert("Payment is Successfull,but we are unable to update payment status on server ,we will contact you soon");
    
            }
    
    
    
    });
    }
                    