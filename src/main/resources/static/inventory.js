
function refreshInventory()
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
                    
            var e = document.getElementById("inventory");
            
            e.innerHTML = productHtml;
        }
    };
    xmlhttp.open("GET", "/api/inventory", true);
    xmlhttp.send();    
}

function submitNewProduct()
{
    var xmlhttp = new XMLHttpRequest();
    
    xmlhttp.onreadystatechange = function() 
    {
        if (this.readyState == 4 && this.status == 200) 
        {
            var result = xmlhttp.responseText
        
            logEvent(result, "logs");    
            
            refreshInventory();
        }
    };
    
//    var queryString = "?" + "name=Tom" + '&' + "role=Underground Resistence";
    
    var data = JSON.stringify({"name": "Tom", "role": "Underground Resistence"});    
    
    xmlhttp.open("POST", "/api/inventory", true);
    
    xmlhttp.setRequestHeader("Content-Type", "application/json");

    xmlhttp.send(data);    
//    xmlhttp.send(queryString);    
}
