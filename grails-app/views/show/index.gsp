<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Gerenciamento de bandas</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <g:javascript library="jquery" />
    <script>

        const definirDataAtualNoCampo = () =>{
            let today = new Date();
            let dd = today.getDate();
            let mm = today.getMonth()+1; //January is 0 so need to add 1 to make it 1!
            let yyyy = today.getFullYear();

            if(dd<10){
                dd='0'+dd
            }
            if(mm<10){
                mm='0'+mm
            }

            today = yyyy+'-'+mm+'-'+dd;
            document.getElementById("dataInput").setAttribute("min", today);
        }

        $(document).ready(definirDataAtualNoCampo)

        function carregarLista(){
            <g:remoteFunction controller="banda" action="listar"  update="divLista" />
        }

        function carregarListaFiltrada(){
            const nome = document.getElementById("inputBuscarPorNome").value
            let listaGenerosMarcados = [...$('input[name="listGeneros[]"]:checked').map(function(){
                return this.value;
            }).get()]

            const parameters = { "nome":nome, "listaGeneros":listaGenerosMarcados}

            <g:remoteFunction controller="banda" action="procurarPorNomeEGenero"  update="divLista"
                params="parameters"/>
        }

        function excluir(id){
            if(confirm("Deseja realmente excluir?")){
                <g:remoteFunction controller="banda" action="excluir" update="divLista" id="'+id+'" />
            }
        }

    </script>
</head>
<body>

<g:remoteLink controller="show" action="prepararForm" update="divForm">Adicionar</g:remoteLink>
<br>

<div id="divLista">
    <g:render template="lista" model="[shows:shows]"></g:render>
</div>

<br>

<div id="divForm"></div>

</body>
</html>