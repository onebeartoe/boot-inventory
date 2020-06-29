
function logEvent(message, divId)
{
    var e = document.getElementById(divId);
    
    var logs = message + "<br/>" + e.innerHTML;
    
    e.innerHTML = logs;
}

function refreshProducts()
{
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() 
    {
        if (this.readyState == 4 && this.status == 200) 
        {
            logEvent("products are loaded", "logs");
          
            var productArray = JSON.parse(this.responseText);
            
            var productHtml = "";
            
            productArray.forEach(element => 
            {
                productHtml += element.name + ":" + element.role;
                
                productHtml += "<br>"
            });
            
            
            
            var e = document.getElementById("products");
            
            e.innerHTML = productHtml;
        }
    };
    xmlhttp.open("GET", "/inventory", true);
    xmlhttp.send();    
}
