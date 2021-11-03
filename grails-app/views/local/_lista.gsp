<g:if test="${locais.size() > 0}">
    <table>
        <caption>Lista de Locais</caption>
        <thead>
            <tr>
                <th>Nome</th>
                <th>Show</th>
                <th>Capacidade</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
        <g:each var="local" in="${locais}">
            <tr>
                <td>${local.nome}</td>
                <td>${local.nomeShow}</td>
                <td>${local.capacidade}</td>
                <td>
                    <a href="#">Alterar</a> &nbsp; &nbsp; &nbsp;
                    <a href="#">Excluir</a>
                </td>
            </tr>
        </g:each>

        </tbody>
    </table>
</g:if>
<g:else>
    <br>
    <h5>Não há locais</h5>
</g:else>