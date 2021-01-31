package db.dao;

import db.dto.AirsoftRifle;

import java.util.ArrayList;

public interface AirsoftRifleDAO {
    public ArrayList<AirsoftRifle> GetAll();
    public boolean createAirsoftRifle(AirsoftRifle AirsoftRifle);
    public AirsoftRifle readAirsoftRifle(int id);
    public boolean updateAirsoftRifle(AirsoftRifle AirsoftRifle);
    public boolean deleteAirsoftRifle(int id);
}
