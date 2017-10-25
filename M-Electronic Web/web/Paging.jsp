 <%
    int previous = 0;
    if(request.getParameter("page") != null){
        previous = Integer.parseInt(request.getParameter("page"));
    }
    request.setAttribute("previous", previous);
 %>
 <%
    int previousDouble = 0;
    if(request.getParameter("page") != null){
        previousDouble = Integer.parseInt(request.getParameter("page"));
    }
    request.setAttribute("previousDouble", previousDouble);
 %>
<div id="PagingDiv" >
    <div id="PagingAlign">
    <c:choose>
        <c:when test="${previousDouble > 2}">
            <div id="PagingDoublePrevious">
                <a class="ex" id="Paging" href="./${subcategory}?page=${previousDouble = previousDouble - 2}"><<</a>
            </div>
        </c:when>
    </c:choose>       
    <c:choose>
        <c:when test="${previous > 1}">
            <div id="PagingPrevious">
                <a class="ex" id="Paging" href="./${subcategory}?page=${previous = previous - 1}">Previous</a>
            </div>
        </c:when>
    </c:choose>

    <c:forEach items="${pagingLinksSubcategorie}" var="page">
        <div id="PageNumber">
            <a class="ex" id="Paging" href="./${subcategory}?page=${page}">${page}</a>
        </div>    
    </c:forEach>

    <c:choose>
        <c:when test="${lastPage > pagingLinksSubcategorie.get(0)}">
            <div id="LastPage">
                <a class="ex" id="Paging" href="./${subcategory}?page=${lastPage}">... ${lastPage}</a>
            </div>
        </c:when>
    </c:choose>

    <%
       int next = 0;
       if(request.getParameter("page") != null){
           next = Integer.parseInt(request.getParameter("page"));
       }
       request.setAttribute("next", next);
    %>

    <c:choose>
        <c:when test="${next < lastPage}">
          <div id="NextPage">  
            <a class="ex" id="Paging" href="./${subcategory}?page=${next = next + 1}">Next</a>
          </div>
        </c:when>
    </c:choose>

    <c:choose>
        <c:when test="${next < lastPage}">
          <div id="DoubleNextPage">  
            <a class="ex" id="Paging" href="./${subcategory}?page=${next = next + 1}">>></a>
          </div>
        </c:when>
    </c:choose>
    </div>      
</div>     
