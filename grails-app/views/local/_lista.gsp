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
                    <g:remoteLink controller="local" action="alterar" update="divForm" id="${local.id}">Alterar</g:remoteLink>
                    &nbsp; &nbsp; &nbsp;
                    <a href="#" onclick="excluir(${local.id})" >Excluir</a>
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