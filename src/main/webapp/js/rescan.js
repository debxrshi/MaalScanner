window.onload = function() {
   var links = document.getElementsByClassName('rescan-link');
   for (var i = 0; i < links.length; i++) {
   	links[i].addEventListener('click', function(e) {
        e.preventDefault();
        var hashValue = e.target.parentElement.parentElement.children[2].innerText;
        window.location.href = 'result.jsp?val=' + hashValue;
     });
   }
};

