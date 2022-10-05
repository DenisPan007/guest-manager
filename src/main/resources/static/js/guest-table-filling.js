function populateGuestTable(guests){
var html = '<table class="table table-striped " style="background-color: rgb(250,250,250);">'
      +'<thead><tr><th scope="col"></th><th scope="col">Имя</th>'
      +'<th scope="col">Пол</th>'
      +'<th scope="col">Стол</th>'
      +'</tr></thead>';
for(var i = 0; i < guests.length; i++){
            html += '<tr>' + '<td></td>'
            + '<td>' + guests[i].name + '</td>'
                +    '<td>' + guests[i].params.sex + '</td>'
                 + '<td>' + guests[i].params.table + '</td>'
                + '</tr>';
}
html += '</table>'
return html;
}