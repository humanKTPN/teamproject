<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.or.ktpn.dto.DTO_md_1000mt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    // 페이지 번호와 페이지 사이즈 설정
    int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
    int pageSize = 10;

    // 검색 파라미터 읽어오기
    String category = request.getParameter("categories");
    String searchTerm = request.getParameter("sel");

    // 전체 목록 받아오기
    List<DTO_md_1000mt> fullList = (List<DTO_md_1000mt>) request.getAttribute("list");
    if (fullList == null) {
        fullList = new ArrayList<DTO_md_1000mt>();
    }
    
    // 검색어가 있을 경우에만 필터링 수행
    if (searchTerm != null && !searchTerm.trim().isEmpty()) {
        List<DTO_md_1000mt> filteredList = new ArrayList();
        for (DTO_md_1000mt item : fullList) {
            if ("전체".equals(category)) {
                if ((item.getMT_MNG_CD() != null && item.getMT_MNG_CD().contains(searchTerm)) ||
                    (item.getMT_MNG_NM() != null && item.getMT_MNG_NM().contains(searchTerm)) ||
                    (item.getMT_MNG_DESC() != null && item.getMT_MNG_DESC().contains(searchTerm))) {
                    filteredList.add(item);
                }
            } else if ("코드".equals(category)) {
                if (item.getMT_MNG_CD() != null && item.getMT_MNG_CD().contains(searchTerm)) {
                    filteredList.add(item);
                }
            } else if ("설명".equals(category)) {
                if (item.getMT_MNG_DESC() != null && item.getMT_MNG_DESC().contains(searchTerm)) {
                    filteredList.add(item);
                }
            } else {
                // 지정된 카테고리가 없거나 일치하지 않으면 전체 검색 수행
                if ((item.getMT_MNG_CD() != null && item.getMT_MNG_CD().contains(searchTerm)) ||
                    (item.getMT_MNG_NM() != null && item.getMT_MNG_NM().contains(searchTerm)) ||
                    (item.getMT_MNG_DESC() != null && item.getMT_MNG_DESC().contains(searchTerm))) {
                    filteredList.add(item);
                }
            }
        }
        fullList = filteredList;
    }
    
    // 페이징 처리: 전체 갯수 기준으로 페이지 수 계산 후 현재 페이지에 해당하는 부분 목록을 추출
    int totalCount = fullList.size();
    int totalPage = (int) Math.ceil((double) totalCount / pageSize);
    int startRow = (currentPage - 1) * pageSize;
    int endRow = startRow + pageSize;
    if (startRow > totalCount) {
        startRow = totalCount;
    }
    if (endRow > totalCount) {
        endRow = totalCount;
    }
    List<DTO_md_1000mt> pagedList = fullList.subList(startRow, endRow);
    
    request.setAttribute("pagedList", pagedList);
    request.setAttribute("currentPage", currentPage);
    request.setAttribute("totalPage", totalPage);
    request.setAttribute("categories", category);
    request.setAttribute("sel", searchTerm);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="resources/css/masterdataManage_main_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/masterdataManage_main_kwak.js"></script>
    <style>
        /* 모바일 버전 구현 등 추가 스타일 */
    </style>
</head>
<body>
    <div class="background">
        <div class="margin">
            <!-- 탭 영역 -->
            <div class="tab-con">
                <div class="tab-name-div"><div class="tab-name switch-color">기준관리</div></div>
                <div class="tab-name-div"><div class="tab-name">BOM</div></div>
                <div class="tab-name-div"><div class="tab-name">공정</div></div>
            </div>

            <!-- 검색 영역 -->
            <div class="dropBox">
                <form action="" method="get">
                    <select name="categories" id="cate">
                        <option value="전체" <c:if test="${categories == '전체'}">selected</c:if>>전체</option>
                        <option value="코드" <c:if test="${categories == '코드'}">selected</c:if>>코드</option>
                        <option value="설명" <c:if test="${categories == '설명'}">selected</c:if>>설명</option>
                    </select>
                    <input type="text" class="sel" name="sel" value="${sel}" placeholder="검색어를 입력하세요">
                    <input type="submit" class="search" value="검색" />
                </form>
            </div>

            <!-- 테이블 영역 -->
            <div class="command-loc">
                <div class="command-div">
                    <table class="command-table">
                        <thead>
                            <tr>
                                <th class="command-th" scope="col">번호</th>
                                <th class="command-th" scope="col">기준관리코드</th>
                                <th class="command-th" scope="col">기준관리명</th>
                                <th class="command-th" scope="col">설명</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${pagedList}" varStatus="status">
                                <tr>
                                    <td class="command-td">${(currentPage - 1) * 10 + status.index + 1}</td>
                                    <td class="command-td">${user.MT_MNG_CD}</td>
                                    <td class="command-td">
                                        <a href="mdDetail?MT_MNG_CD=${user.MT_MNG_CD}">
                                            ${user.MT_MNG_NM}
                                        </a>
                                    </td>
                                    <td class="command-td">${user.MT_MNG_DESC}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <!-- 페이징 버튼 -->
                    <div class="page-num-con">
                        <div class="page-num">
                            <!-- 이전 버튼 -->
                            <c:choose>
                                <c:when test="${currentPage > 1}">
                                    <a href="?page=${currentPage - 1}&categories=${categories}&sel=${sel}" class="page pre-page">이전</a>
                                </c:when>
                                <c:otherwise>
                                    <span class="page pre-page disabled">이전</span>
                                </c:otherwise>
                            </c:choose>
                        
                            <!-- 페이지 번호 -->
                            <c:forEach begin="1" end="${totalPage}" var="i">
                                <a href="?page=${i}&categories=${categories}&sel=${sel}" class="num <c:if test='${i == currentPage}'>bold</c:if>">${i}</a>
                            </c:forEach>
                        
                            <!-- 다음 버튼 -->
                            <c:choose>
                                <c:when test="${currentPage < totalPage}">
                                    <a href="?page=${currentPage + 1}&categories=${categories}&sel=${sel}" class="page next-page">다음</a>
                                </c:when>
                                <c:otherwise>
                                    <span class="page next-page disabled">다음</span>
                                </c:otherwise>
                            </c:choose>
                        </div>
					<c:if test="${ID.mbr_nm eq '관리자'}">
					    <div class="add-con">
					        <div class="add">추가</div>
					    </div>
					</c:if>
                    </div>
                </div> <!-- command-div -->
            </div> <!-- command-loc -->
        </div> <!-- margin -->
    </div> <!-- background -->
</body>
</html>
