package kr.co.nandsoft.member.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import kr.co.nandsoft.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MemberDao implements IMemberDao {

    private JdbcTemplate template;

    @Autowired
    public MemberDao(ComboPooledDataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public int memberInsert(final Member member) {

        int result = 0;

        String sql = "INSERT INTO member (memId, memPw, memMail) values (?,?,?)";

        result = template.update(sql, pstmt -> {
            pstmt.setString(1, member.getMemId());
            pstmt.setString(2, member.getMemPw());
            pstmt.setString(3, member.getMemMail());

        });

        return result;
    }

    @Override
    public Member memberSelect(Member member) {

        List<Member> members = null;

        final String sql = "SELECT * FROM member WHERE memId = ? AND memPw = ?";

        members = template.query(sql, new Object[]{member.getMemId(), member.getMemPw()}, (rs, rowNum) -> {
            Member mem = new Member();
            mem.setMemId(rs.getString("memId"));
            mem.setMemPw(rs.getString("memPw"));
            mem.setMemMail(rs.getString("memMail"));
            return mem;
        });
        if (members.isEmpty())
            return null;

        return members.get(0);
    }

    @Override
    public int memberUpdate(final Member member) {

        int result = 0;

        final String sql = "UPDATE member SET memPw = ?, memMail = ? WHERE memId = ?";

        result = template.update(sql, pstmt -> {
            pstmt.setString(1, member.getMemPw());
            pstmt.setString(2, member.getMemMail());
            pstmt.setString(3, member.getMemId());
        });
        return result;

    }

    @Override
    public int memberDelete(final Member member) {

        int result = 0;

        final String sql = "DELETE member WHERE memId = ? AND memPw = ?";

        result = template.update(sql, pstmt -> {
            pstmt.setString(1, member.getMemId());
            pstmt.setString(2, member.getMemPw());
        });

        return result;
    }
}