<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper title="Mascota">
    <h1 class="page-header"> Nueva Visita </h1>

    <form action="${pageContext.request.contextPath}/com/atencion/save" method="post">

        <input type="hidden" name="id" value="${atencion.id}"/>


        <div class="form-group">
            <select name="especie.id" class="form-control">
                <c:forEach items="${mascotas}" var="e" >
                    <option value="${e.id}"> ${e.nombre} </option>
                </c:forEach>
            </select>
        </div>




    </form>



</t:wrapper>



