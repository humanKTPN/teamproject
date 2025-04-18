<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>공정 수정</title>
    <link rel="stylesheet" href="resources/css/processDesc_mod.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/processDesc_select.js"></script>
</head>
<body>
            <div class="menuPage-con">
                <div class="border_line">
                    <div class="pop">
                        <div class="add-table">
                            <form method="post" action="rtMod" class="postCon">
                                <c:set var="dt" value="${dt[0]}" />
                                <table class="detail-table">
                                    <tr>
                                        <th class="detail-th">공정코드</th>
                                        <th class="detail-th">공정명</th>
                                        <th class="detail-th">품목코드</th>
                                    </tr>
                                    <tr>
                                        <td class="detail-td">
                                            <span class="spn-td">
                                                <input type="text" value="${dt.rt_cd}" name="rt_cd" disabled />
                                                <input type="hidden" name="rt_cd" value="${dt.rt_cd}" />
                                            </span>
                                        </td>
                                        <td class="detail-td">
                                            <span class="spn-td">
                                                <input type="text" value="${dt.rt_nm}" name="rt_nm" disabled />
                                            </span>
                                        </td>
                                        <td class="detail-td">
                                            <span class="spn-td">
                                                <input type="text" value="${dt.item_cd}" name="item_cd" disabled/>
                                            </span>
                                        </td>
                                    </tr>
                                </table>

                                <div class="bompro-con">
                                    <div class="bom-con">
                                        <h4>공정코드 :
                                            <span class="spn-td">
                                                <input type="text" value="${dt.rt_cd}" disabled />
                                            </span>
                                        </h4>
                                        <table>
                                            <tr>
                                                <td>
                                                    <textarea name="rt_desc" style="width:300px; height:300px;">${dt.rt_desc}</textarea>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>

                                <div class="add-con">
                                    <div class="mode-con">
                                        <input type="submit" class="mod" value="완료" />
                                        <input type="hidden" name="command" value="완료" />
                                    </div>
                                </div>
                            </form>
                        </div> <!-- add-table -->
                    </div> 
                </div> <!-- border_line -->
            </div> <!-- menuPage-con -->
</body>
</html>
