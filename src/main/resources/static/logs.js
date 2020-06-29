
function logEvent(message, divId)
{
    var e = document.getElementById(divId);
    
    var logs = message + "<br/>" + e.innerHTML;
    
    e.innerHTML = logs;
}

