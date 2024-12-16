package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Nút "Add to cart"
        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thêm Media vào giỏ hàng (thực hiện hành động)
                JOptionPane.showMessageDialog(null, media.getTitle() + " added to cart!");
            }
        });
        container.add(btnAddToCart);

        // Nút "Play" (chỉ hiển thị khi Media là Playable)
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Chơi Media (hiển thị hộp thoại)
                    JDialog playDialog = new JDialog();
                    playDialog.setTitle("Playing Media");
                    playDialog.setSize(300, 200);
                    playDialog.setLayout(new BorderLayout());

                    JLabel playLabel = new JLabel("Playing: " + media.getTitle(), SwingConstants.CENTER);
                    playDialog.add(playLabel, BorderLayout.CENTER);

                    playDialog.setVisible(true);
                }
            });
            container.add(btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

}
