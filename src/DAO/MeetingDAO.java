package DAO;
import java.sql.*;
import java.time.LocalDate;

public class MeetingDAO {
    // insert meetings 회의 정보를 추가
    public static void insertMeeting(Connection con, String t,
                                      String d, String l){
        String sql = "INSERT INTO meetings(title,date,location) " +
                     "VALUES(?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            pst.setDate(2, Date.valueOf(d));
            pst.setString(3, l);
            pst.executeUpdate();
            System.out.println("회의록 정보 추가 성공!!");
        } catch (SQLException e) {
            System.out.println("회의록 등록중 예외 발생 : " +  e.getMessage());
        }
    }

    // 삭제
    public static void deleteMeeting(Connection con, int meeting_id){
        String sql = "DELETE FROM meetings WHERE id = ?";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, meeting_id);
            int rows = pst.executeUpdate();  // 1 or 0
            if(rows > 0){
                System.out.println("회의 정보 삭제 성공: " +  meeting_id+ " 삭제 완료");
            }else{
                System.out.println("회의 정보 삭제 불가: "+ meeting_id + " 정보 없음.");
            }

        } catch (SQLException e) {
            System.out.println("회의 정보 삭제 중에 SQL예외 발생: "+ e.getMessage());
        }
    }

    // 수정
    public static void updateMeeting(Connection con, String title, String date,
                                      String location, int meeting_id)
    {
        String sql = "UPDATE meetings SET title = ?, date = ?, location = ? " +
                     "WHERE id = ?";

        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, title);
            pst.setDate(2, Date.valueOf(date));
            pst.setString(3, location);
            pst.setInt(4, meeting_id);
            int rows = pst.executeUpdate();
            if(rows > 0){
                System.out.println("회의 정보 수정 성공: " + meeting_id +" 수정 완료");
            }else{
                System.out.println("회의 정보 수정 실패: " + meeting_id +" 정보 없음");
            }

        }catch(Exception e){

            System.out.println("회의 정보 수정 예외 발생: " + e.getMessage());
        }

    }


    // 조회

}
