var username=document.forms['form']['username'];
var password=document.forms['form']['password'];
var pwd=document.forms['form']['pwd'];
var phoneNumber=document.forms['form']['phoneNumber'];

var username_error=document.getElementById('username_error');
var pass_error=document.getElementById('pass_error');
var pass_error2=document.getElementById('pass_error2');
var phone_error=document.getElementById('phone_error');

username.addEventListener('textInput',username_Verify);
password.addEventListener('textInput',pass_Verify);
pwd.addEventListener('textInput',pass_Verify2);
phoneNumber.addEventListener('textInput',phone_Verify);

function validated(){
    if(username.value.length < 1)
    {
        username.style.border="1px solid red";
        username_error.style.display="block";
        username.focus();
        return false;
    }
    if(password.value.length < 8)
    {
        password.style.border="1px solid red";
        pass_error.style.display="block";
        password.focus();
        return false;
    }
    if(!(pwd.value === password.value))
    {
        pwd.style.border="1px solid red";
        pass_error2.style.display="block";
        pwd.focus();
        return false;
    }
    if(phoneNumber.value.length < 10)
    {
        phoneNumber.style.border="1px solid red";
        phone_error.style.display="block";
        phoneNumber.focus();
        return false;
    }
}

function username_Verify()
{
    if(username.value.length >=1)
    {
        username.style.border="1px solid silver";
        username_error.style.display="none";
        return true;
    }
}

function pass_Verify() // minimum 8 characters password
{
    if(password.value.length >=7)
    {
        password.style.border="1px solid silver";
        pass_error.style.display="none";
        return true;
    }
}

function pass_Verify2()
{
    if(password.value === pwd.value)
    {
        pwd.style.border="1px solid silver";
        pass_error2.style.display="none";
        return true;
    }
}

function phone_Verify()
{
    if(phoneNumber.value.length >= 9)
    {
        phoneNumber.style.border="1px solid silver";
        phone_error.style.display="none";
        return true;
    }
}